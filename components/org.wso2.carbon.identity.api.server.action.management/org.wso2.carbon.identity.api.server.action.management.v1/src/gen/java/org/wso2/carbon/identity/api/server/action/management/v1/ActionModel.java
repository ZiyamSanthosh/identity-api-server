/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.api.server.action.management.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.wso2.carbon.identity.api.server.action.management.v1.Endpoint;
import org.wso2.carbon.identity.api.server.action.management.v1.ORRule;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class ActionModel  {
  
    private String name;
    private String description;
    private Endpoint endpoint;
    private ORRule rule;

    /**
    * Name of the action.
    **/
    public ActionModel name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "Pre Issue Access Token Action", required = true, value = "Name of the action.")
    @JsonProperty("name")
    @Valid
    @NotNull(message = "Property name cannot be null.")
    @Size(min=1,max=255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Description of the action.
    **/
    public ActionModel description(String description) {

        this.description = description;
        return this;
    }
    
    @ApiModelProperty(example = "This action invokes before issuing an access token.", value = "Description of the action.")
    @JsonProperty("description")
    @Valid @Size(max=255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    **/
    public ActionModel endpoint(Endpoint endpoint) {

        this.endpoint = endpoint;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("endpoint")
    @Valid
    @NotNull(message = "Property endpoint cannot be null.")

    public Endpoint getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
    **/
    public ActionModel rule(ORRule rule) {

        this.rule = rule;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("rule")
    @Valid
    public ORRule getRule() {
        return rule;
    }
    public void setRule(ORRule rule) {
        this.rule = rule;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActionModel actionModel = (ActionModel) o;
        return Objects.equals(this.name, actionModel.name) &&
            Objects.equals(this.description, actionModel.description) &&
            Objects.equals(this.endpoint, actionModel.endpoint) &&
            Objects.equals(this.rule, actionModel.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, endpoint, rule);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class ActionModel {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

