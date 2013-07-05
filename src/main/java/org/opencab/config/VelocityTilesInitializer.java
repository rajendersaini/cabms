package org.opencab.config;

import java.util.List;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.context.ChainedTilesRequestContextFactory;
import org.apache.tiles.context.TilesRequestContextFactory;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.renderer.AttributeRenderer;
import org.apache.tiles.renderer.impl.BasicRendererFactory;
import org.apache.tiles.startup.DefaultTilesInitializer;
import org.apache.tiles.velocity.context.VelocityTilesRequestContextFactory;
import org.springframework.web.servlet.view.velocity.VelocityConfig;

public class VelocityTilesInitializer extends DefaultTilesInitializer {
	private VelocityConfig velocityConfig;

	public VelocityTilesInitializer(VelocityConfig velocityConfig) {
		this.velocityConfig = velocityConfig;
	}

	@Override
	protected AbstractTilesContainerFactory createContainerFactory(
			TilesApplicationContext context) {
		return new BasicTilesContainerFactory() {

			@Override
			protected List<TilesRequestContextFactory> getTilesRequestContextFactoriesToBeChained(
					ChainedTilesRequestContextFactory parent) {
				List<TilesRequestContextFactory> factories = super
						.getTilesRequestContextFactoriesToBeChained(parent);
				registerRequestContextFactory(
						VelocityTilesRequestContextFactory.class.getName(),
						factories, parent);
				return factories;
			}

			@Override
			protected AttributeRenderer createTemplateAttributeRenderer(
					BasicRendererFactory rendererFactory,
					TilesApplicationContext applicationContext,
					TilesRequestContextFactory contextFactory,
					TilesContainer container,
					AttributeEvaluatorFactory attributeEvaluatorFactory) {
				ContextPassingVelocityAttributeRenderer var = new ContextPassingVelocityAttributeRenderer(
						velocityConfig.getVelocityEngine());
				var.setApplicationContext(applicationContext);
				var.setRequestContextFactory(contextFactory);
				var.setAttributeEvaluatorFactory(attributeEvaluatorFactory);
				var.commit();
				return var;
			}
		};
	}
}
