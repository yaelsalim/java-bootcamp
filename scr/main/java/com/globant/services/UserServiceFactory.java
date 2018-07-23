package com.globant.services;

/**
 * This is a user service factory.
 * 
 * @author Yael Salim
 *
 */
public class UserServiceFactory {

	private UserServiceFactory() {
	}

	/**
	 * Returns a local instance of the service
	 * 
	 * @return
	 */
	public static UserService getLocalService() {
		return new UserServiceImpl();
	}

	/**
	 * Returns a remote instance of the service using a proxy
	 * 
	 * @return
	 */
	public static UserService getRemoteServiceUsingWebService() {
		return new UserServiceProxy(new UserWebServiceClient());
	}

}
