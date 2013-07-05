package org.opencab.config;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.tiles.Attribute;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.impl.InvalidTemplateException;
import org.apache.tiles.renderer.impl.AbstractTypeDetectingAttributeRenderer;
import org.apache.tiles.servlet.context.ServletUtil;
import org.apache.tiles.util.IteratorEnumeration;
import org.apache.tiles.velocity.context.VelocityTilesRequestContext;
import org.apache.tiles.velocity.renderer.VelocityAttributeRenderer;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.tools.view.JeeConfig;
import org.apache.velocity.tools.view.VelocityView;

public class ContextPassingVelocityAttributeRenderer extends
		AbstractTypeDetectingAttributeRenderer {

	/**
	 * The VelocityView object to use.
	 */
	private VelocityView velocityView;

	/**
	 * The initialization parameters for VelocityView.
	 */
	private Map<String, String> params = new HashMap<String, String>();

	private VelocityEngine engine;

	public ContextPassingVelocityAttributeRenderer(VelocityEngine engine) {
		this.engine = engine;
	}

	/**
	 * Sets a parameter for the internal servlet.
	 * 
	 * @param key
	 *            The name of the parameter.
	 * @param value
	 *            The value of the parameter.
	 * @since 2.2.0
	 */
	public void setParameter(String key, String value) {
		params.put(key, value);
	}

	/**
	 * Commits the parameters and makes this renderer ready for the use.
	 * 
	 * @since 2.2.0
	 */
	public void commit() {
		velocityView = new VelocityView(new TilesApplicationContextJeeConfig());
		velocityView.setVelocityEngine(engine);
	}

	/** {@inheritDoc} */
	@Override
	public void write(Object value, Attribute attribute,
			TilesRequestContext request) throws IOException {
		if (value != null) {
			if (value instanceof String) {
				InternalContextAdapter adapter = (InternalContextAdapter) ((VelocityTilesRequestContext) request)
						.getRequestObjects()[0];
				Context context = adapter.getInternalUserContext();
				Template template = velocityView.getTemplate((String) value);
				velocityView.merge(template, context, request.getWriter());
			} else {
				throw new InvalidTemplateException(
						"Cannot render a template that is not a string: "
								+ value.toString());
			}
		} else {
			throw new InvalidTemplateException("Cannot render a null template");
		}
	}

	/** {@inheritDoc} */
	public boolean isRenderable(Object value, Attribute attribute,
			TilesRequestContext request) {
		if (value instanceof String) {
			String string = (String) value;
			return string.startsWith("/") && string.endsWith(".vm");
		}
		return false;
	}

	/**
	 * Implements JeeConfig to use parameters set through
	 * {@link VelocityAttributeRenderer#setParameter(String, String)}.
	 * 
	 * @version $Rev: 821299 $ $Date: 2009-10-03 14:15:05 +0200 (sab, 03 ott
	 *          2009) $
	 * @since 2.2.0
	 */
	private class TilesApplicationContextJeeConfig implements JeeConfig {

		/** {@inheritDoc} */
		public String getInitParameter(String name) {
			return params.get(name);
		}

		/** {@inheritDoc} */
		public String findInitParameter(String key) {
			return params.get(key);
		}

		/** {@inheritDoc} */
		@SuppressWarnings("unchecked")
		public Enumeration getInitParameterNames() {
			return new IteratorEnumeration(params.keySet().iterator());
		}

		/** {@inheritDoc} */
		public String getName() {
			return "Tiles Application Context JEE Config";
		}

		/** {@inheritDoc} */
		public ServletContext getServletContext() {
			return ServletUtil.getServletContext(applicationContext);
		}
	}

}
