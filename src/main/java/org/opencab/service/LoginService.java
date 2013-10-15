package org.opencab.service;

import org.opencab.bean.LoginDetails;

public interface LoginService {
    public abstract LoginDetails getLoginDetails(String userName);

}
