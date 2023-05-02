/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.api.server.idle.account.identification.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import java.io.InputStream;
import java.util.List;

import org.wso2.carbon.identity.api.server.idle.account.identification.v1.model.Error;
import org.wso2.carbon.identity.api.server.idle.account.identification.v1.model.InactiveUser;
import org.wso2.carbon.identity.api.server.idle.account.identification.v1.model.Unauthorized;
import org.wso2.carbon.identity.api.server.idle.account.identification.v1.InactiveUsersApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/inactive-users")
@Api(description = "The inactive-users API")

public class InactiveUsersApi  {

    @Autowired
    private InactiveUsersApiService delegate;

    @Valid
    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Get inactive users list for a specified period.", response = InactiveUser.class, responseContainer = "List", tags={ "Get inactive users" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Inactive users returned successfully", response = InactiveUser.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid Input Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Unauthorized.class),
        @ApiResponse(code = 403, message = "Resource Forbidden", response = Void.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Response getInactiveUsers(    @Valid@ApiParam(value = "Latest active date of login.")  @QueryParam("inactiveAfter") String inactiveAfter,     @Valid@ApiParam(value = "Date to exclude the oldest inactive users.")  @QueryParam("excludeBefore") String excludeBefore) {

        return delegate.getInactiveUsers(inactiveAfter,  excludeBefore );
    }

}
