/*
 * Copyright (c) 2020-2025, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.server.oidc.scope.management.v1.impl;

import org.wso2.carbon.identity.api.server.common.Constants;
import org.wso2.carbon.identity.api.server.common.ContextLoader;
import org.wso2.carbon.identity.api.server.oidc.scope.management.common.OidcScopeConstants;
import org.wso2.carbon.identity.api.server.oidc.scope.management.v1.OidcApiService;
import org.wso2.carbon.identity.api.server.oidc.scope.management.v1.core.OidcScopeManagementService;
import org.wso2.carbon.identity.api.server.oidc.scope.management.v1.factories.OidcScopeManagementServiceFactory;
import org.wso2.carbon.identity.api.server.oidc.scope.management.v1.model.Scope;
import org.wso2.carbon.identity.api.server.oidc.scope.management.v1.model.ScopeUpdateRequest;

import java.net.URI;

import javax.ws.rs.core.Response;

/**
 * API service implementation of OIDC scope management service operations.
 */
public class OidcApiServiceImpl implements OidcApiService {

    private final OidcScopeManagementService oidcScopeManagementService;

    public OidcApiServiceImpl() {

        try {
            this.oidcScopeManagementService = OidcScopeManagementServiceFactory.getPermissionManagementService();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Error occurred while initiating OidcScopeManagementService.", e);
        }
    }

    @Override
    public Response addScope(Scope scope) {

        String resourceId = oidcScopeManagementService.addScope(scope);
        return Response.created(getResourceLocation(resourceId)).build();
    }

    @Override
    public Response deleteScope(String id) {

        oidcScopeManagementService.deleteScope(id);
        return Response.noContent().build();
    }

    @Override
    public Response getScope(String id) {

        return Response.ok().entity(oidcScopeManagementService.getScope(id)).build();
    }

    @Override
    public Response getScopes() {

        return Response.ok().entity(oidcScopeManagementService.getScopes()).build();
    }

    @Override
    public Response updateScope(String id, ScopeUpdateRequest scopeUpdateRequest) {

        oidcScopeManagementService.updateScope(id, scopeUpdateRequest);
        return Response.ok().build();
    }

    private URI getResourceLocation(String resourceId) {

        return ContextLoader.buildURIForHeader(Constants.V1_API_PATH_COMPONENT +
                OidcScopeConstants.OIDC_SCOPE_API_PATH_COMPONENT + OidcScopeConstants.PATH_SEPERATOR + resourceId);
    }
}
