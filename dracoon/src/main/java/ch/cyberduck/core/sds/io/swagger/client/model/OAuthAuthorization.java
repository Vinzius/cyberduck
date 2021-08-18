/*
 * DRACOON API
 * REST Web Services for DRACOON<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.30.0-beta.4
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
import org.joda.time.DateTime;
/**
 * OAuth authorization
 */
@Schema(description = "OAuth authorization")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-16T11:28:10.116221+02:00[Europe/Zurich]")
public class OAuthAuthorization {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientName")
  private String clientName = null;

  /**
   * &amp;#128640; Since v4.12.0  User agent category.
   */
  public enum UserAgentCategoryEnum {
    BROWSER("browser"),
    NATIVE("native"),
    UNKNOWN("unknown");

    private String value;

    UserAgentCategoryEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static UserAgentCategoryEnum fromValue(String text) {
      for (UserAgentCategoryEnum b : UserAgentCategoryEnum.values()) {
        if (b.value.equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("userAgentCategory")
  private UserAgentCategoryEnum userAgentCategory = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("isStandard")
  private Boolean isStandard = null;

  @JsonProperty("createdAt")
  private DateTime createdAt = null;

  @JsonProperty("usedAt")
  private DateTime usedAt = null;

  @JsonProperty("expiresAt")
  private DateTime expiresAt = null;

  @JsonProperty("userAgentType")
  private String userAgentType = null;

  @JsonProperty("userAgentOs")
  private String userAgentOs = null;

  @JsonProperty("userAgentInfo")
  private String userAgentInfo = null;

  @JsonProperty("isCurrentAuthorization")
  private Boolean isCurrentAuthorization = null;

  public OAuthAuthorization clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * ID of the OAuth client
   * @return clientId
  **/
  @Schema(required = true, description = "ID of the OAuth client")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public OAuthAuthorization clientName(String clientName) {
    this.clientName = clientName;
    return this;
  }

   /**
   * Name, which is shown at the client configuration and authorization.
   * @return clientName
  **/
  @Schema(required = true, description = "Name, which is shown at the client configuration and authorization.")
  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public OAuthAuthorization userAgentCategory(UserAgentCategoryEnum userAgentCategory) {
    this.userAgentCategory = userAgentCategory;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  User agent category.
   * @return userAgentCategory
  **/
  @Schema(required = true, description = "&#128640; Since v4.12.0  User agent category.")
  public UserAgentCategoryEnum getUserAgentCategory() {
    return userAgentCategory;
  }

  public void setUserAgentCategory(UserAgentCategoryEnum userAgentCategory) {
    this.userAgentCategory = userAgentCategory;
  }

  public OAuthAuthorization id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  ID of the OAuth authorization
   * @return id
  **/
  @Schema(description = "&#128640; Since v4.12.0  ID of the OAuth authorization")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OAuthAuthorization isStandard(Boolean isStandard) {
    this.isStandard = isStandard;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  Determines whether client is a standard client.
   * @return isStandard
  **/
  @Schema(description = "&#128640; Since v4.12.0  Determines whether client is a standard client.")
  public Boolean isIsStandard() {
    return isStandard;
  }

  public void setIsStandard(Boolean isStandard) {
    this.isStandard = isStandard;
  }

  public OAuthAuthorization createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Creation date of the authorization
   * @return createdAt
  **/
  @Schema(description = "&#128640; Since v4.13.0  Creation date of the authorization")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public OAuthAuthorization usedAt(DateTime usedAt) {
    this.usedAt = usedAt;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Usage date of the authorization  (Time of last usage.)
   * @return usedAt
  **/
  @Schema(description = "&#128640; Since v4.13.0  Usage date of the authorization  (Time of last usage.)")
  public DateTime getUsedAt() {
    return usedAt;
  }

  public void setUsedAt(DateTime usedAt) {
    this.usedAt = usedAt;
  }

  public OAuthAuthorization expiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * Expiration date of the authorization
   * @return expiresAt
  **/
  @Schema(description = "Expiration date of the authorization")
  public DateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public OAuthAuthorization userAgentType(String userAgentType) {
    this.userAgentType = userAgentType;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  User agent type.
   * @return userAgentType
  **/
  @Schema(description = "&#128640; Since v4.12.0  User agent type.")
  public String getUserAgentType() {
    return userAgentType;
  }

  public void setUserAgentType(String userAgentType) {
    this.userAgentType = userAgentType;
  }

  public OAuthAuthorization userAgentOs(String userAgentOs) {
    this.userAgentOs = userAgentOs;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  User agent OS.
   * @return userAgentOs
  **/
  @Schema(description = "&#128640; Since v4.12.0  User agent OS.")
  public String getUserAgentOs() {
    return userAgentOs;
  }

  public void setUserAgentOs(String userAgentOs) {
    this.userAgentOs = userAgentOs;
  }

  public OAuthAuthorization userAgentInfo(String userAgentInfo) {
    this.userAgentInfo = userAgentInfo;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  User agent info.
   * @return userAgentInfo
  **/
  @Schema(description = "&#128640; Since v4.12.0  User agent info.")
  public String getUserAgentInfo() {
    return userAgentInfo;
  }

  public void setUserAgentInfo(String userAgentInfo) {
    this.userAgentInfo = userAgentInfo;
  }

  public OAuthAuthorization isCurrentAuthorization(Boolean isCurrentAuthorization) {
    this.isCurrentAuthorization = isCurrentAuthorization;
    return this;
  }

   /**
   * &amp;#128640; Since v4.25.0  Determines whether authorization matches the one from Authorization Header
   * @return isCurrentAuthorization
  **/
  @Schema(description = "&#128640; Since v4.25.0  Determines whether authorization matches the one from Authorization Header")
  public Boolean isIsCurrentAuthorization() {
    return isCurrentAuthorization;
  }

  public void setIsCurrentAuthorization(Boolean isCurrentAuthorization) {
    this.isCurrentAuthorization = isCurrentAuthorization;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OAuthAuthorization oauthAuthorization = (OAuthAuthorization) o;
    return Objects.equals(this.clientId, oauthAuthorization.clientId) &&
        Objects.equals(this.clientName, oauthAuthorization.clientName) &&
        Objects.equals(this.userAgentCategory, oauthAuthorization.userAgentCategory) &&
        Objects.equals(this.id, oauthAuthorization.id) &&
        Objects.equals(this.isStandard, oauthAuthorization.isStandard) &&
        Objects.equals(this.createdAt, oauthAuthorization.createdAt) &&
        Objects.equals(this.usedAt, oauthAuthorization.usedAt) &&
        Objects.equals(this.expiresAt, oauthAuthorization.expiresAt) &&
        Objects.equals(this.userAgentType, oauthAuthorization.userAgentType) &&
        Objects.equals(this.userAgentOs, oauthAuthorization.userAgentOs) &&
        Objects.equals(this.userAgentInfo, oauthAuthorization.userAgentInfo) &&
        Objects.equals(this.isCurrentAuthorization, oauthAuthorization.isCurrentAuthorization);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientName, userAgentCategory, id, isStandard, createdAt, usedAt, expiresAt, userAgentType, userAgentOs, userAgentInfo, isCurrentAuthorization);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthAuthorization {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientName: ").append(toIndentedString(clientName)).append("\n");
    sb.append("    userAgentCategory: ").append(toIndentedString(userAgentCategory)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isStandard: ").append(toIndentedString(isStandard)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    usedAt: ").append(toIndentedString(usedAt)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    userAgentType: ").append(toIndentedString(userAgentType)).append("\n");
    sb.append("    userAgentOs: ").append(toIndentedString(userAgentOs)).append("\n");
    sb.append("    userAgentInfo: ").append(toIndentedString(userAgentInfo)).append("\n");
    sb.append("    isCurrentAuthorization: ").append(toIndentedString(isCurrentAuthorization)).append("\n");
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
