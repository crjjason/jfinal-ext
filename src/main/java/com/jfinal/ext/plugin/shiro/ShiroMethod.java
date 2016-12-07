/**
 * Copyright (c) 2011-2013, dafei 李飞 (myaniu AT gmail DOT com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jfinal.ext.plugin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * ShiroMethod. (SPI, Singleton, ThreadSafe)
 *
 * @author dafei (myaniu AT gmail DOT com)
 */
public class ShiroMethod {

	private static final String NAMES_DELIMETER = ",";

	/**
	 */
	private ShiroMethod() {}

	/**
	 *
	 * @return Subject
	 */
	protected static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 *
	 * @param roleName
	 * @return
	 */
	public static boolean hasRole(String roleName) {
		return getSubject() != null && roleName != null
				&& roleName.length() > 0 && getSubject().hasRole(roleName);
	}

	/**
	 *
	 * @param roleName
	 * @return
	 */
	public static boolean lacksRole(String roleName) {
		return !hasRole(roleName);
	}

	/**
	 *
	 * @param roleNames
	 * @return
	 */
	public static boolean hasAnyRoles(String roleNames) {
		boolean hasAnyRole = false;
		Subject subject = getSubject();
		if (subject != null && roleNames != null && roleNames.length() > 0) {
			// Iterate through roles and check to see if the user has one of the
			// roles
			for (String role : roleNames.split(NAMES_DELIMETER)) {
				if (subject.hasRole(role.trim())) {
					hasAnyRole = true;
					break;
				}
			}
		}
		return hasAnyRole;
	}

	/**
	 *
	 * @param roleNames
	 *
	 * @return
	 */
	public static boolean hasAllRoles(String roleNames) {
		boolean hasAllRole = true;
		Subject subject = getSubject();
		if (subject != null && roleNames != null && roleNames.length() > 0) {
			// Iterate through roles and check to see if the user has one of the
			// roles
			for (String role : roleNames.split(NAMES_DELIMETER)) {
				if (!subject.hasRole(role.trim())) {
					hasAllRole = false;
					break;
				}
			}
		}
		return hasAllRole;
	}

	/**
	 *
	 * @param permission
	 * @return
	 */
	public static boolean hasPermission(String permission) {
		return getSubject() != null && permission != null
				&& permission.length() > 0
				&& getSubject().isPermitted(permission);
	}

	/**
	 *
	 * @param permission
	 * @return
	 */
	public static boolean lacksPermission(String permission) {
		return !hasPermission(permission);
	}

	/**
	 *
	 * @return
	 */
	public static boolean authenticated() {
		return getSubject() != null && getSubject().isAuthenticated();
	}

	/**
	 *
	 * @return
	 */
	public static boolean notAuthenticated() {
		return !authenticated();
	}

	/**
	 *
	 */
	public static boolean user() {
		return getSubject() != null && getSubject().getPrincipal() != null;
	}

	/**
	 *
	 * @return
	 */
	public static boolean guest() {
		return !user();
	}

	/**
	 * @return
	 */
	public String principal(){
		if (getSubject() != null) {
            // Get the principal to print out
            Object principal = getSubject().getPrincipal();
            return principal.toString();
        }
		return "Guest";
	}
}
