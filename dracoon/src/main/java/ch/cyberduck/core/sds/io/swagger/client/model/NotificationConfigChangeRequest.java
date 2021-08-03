/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 1970-01-01 00:00:00.000<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.28.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Request model for updating notification configuration
 */
@Schema(description = "Request model for updating notification configuration")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T23:34:01.480829+02:00[Europe/Paris]")
public class NotificationConfigChangeRequest {
  @JsonProperty("channelIds")
  private List<Integer> channelIds = new ArrayList<>();

  public NotificationConfigChangeRequest channelIds(List<Integer> channelIds) {
    this.channelIds = channelIds;
    return this;
  }

  public NotificationConfigChangeRequest addChannelIdsItem(Integer channelIdsItem) {
    this.channelIds.add(channelIdsItem);
    return this;
  }

   /**
   * List of notification channel IDs.  Leave empty to disable notifications.
   * @return channelIds
  **/
  @Schema(required = true, description = "List of notification channel IDs.  Leave empty to disable notifications.")
  public List<Integer> getChannelIds() {
    return channelIds;
  }

  public void setChannelIds(List<Integer> channelIds) {
    this.channelIds = channelIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationConfigChangeRequest notificationConfigChangeRequest = (NotificationConfigChangeRequest) o;
    return Objects.equals(this.channelIds, notificationConfigChangeRequest.channelIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationConfigChangeRequest {\n");
    
    sb.append("    channelIds: ").append(toIndentedString(channelIds)).append("\n");
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
    return o.toString().replace("\n", "\n    ");
  }

}
