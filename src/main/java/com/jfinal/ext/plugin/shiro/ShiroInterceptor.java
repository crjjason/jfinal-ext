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

import com.jfinal.aop.Invocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;

import com.jfinal.aop.Interceptor;

public class ShiroInterceptor implements Interceptor {

	@Override
    public void intercept(Invocation ai) {
		AuthzHandler ah = ShiroKit.getAuthzHandler(ai.getActionKey());
		if (ah != null) {
			try {
				ah.assertAuthorized();
			} catch (UnauthenticatedException lae) {
				ai.getController().renderError(401);
				return;
			} catch (AuthorizationException ae) {
				ai.getController().renderError(403);
				return;
			} catch (Exception e) {
				ai.getController().renderError(401);
				return;
			}
		}
		ai.invoke();
	}
}
