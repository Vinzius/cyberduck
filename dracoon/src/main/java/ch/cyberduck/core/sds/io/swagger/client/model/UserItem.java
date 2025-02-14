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
import ch.cyberduck.core.sds.io.swagger.client.model.RoleList;
import ch.cyberduck.core.sds.io.swagger.client.model.UserAttributes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * User information
 */
@Schema(description = "User information")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-16T11:28:10.116221+02:00[Europe/Zurich]")
public class UserItem {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("isLocked")
  private Boolean isLocked = false;

  @JsonProperty("hasManageableRooms")
  private Boolean hasManageableRooms = null;

  @JsonProperty("avatarUuid")
  private String avatarUuid = null;

  @JsonProperty("createdAt")
  private DateTime createdAt = null;

  @JsonProperty("lastLoginSuccessAt")
  private DateTime lastLoginSuccessAt = null;

  @JsonProperty("expireAt")
  private DateTime expireAt = null;

  @JsonProperty("isEncryptionEnabled")
  private Boolean isEncryptionEnabled = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("homeRoomId")
  private Long homeRoomId = null;

  @JsonProperty("userRoles")
  private RoleList userRoles = null;

  @JsonProperty("userAttributes")
  private UserAttributes userAttributes = null;

  @JsonProperty("lockStatus")
  private Integer lockStatus = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("gender")
  private String gender = "n";

  public UserItem id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return id
  **/
  @Schema(required = true, description = "Unique identifier for the user")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserItem userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Username
   * @return userName
  **/
  @Schema(required = true, description = "&#128640; Since v4.13.0  Username")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserItem firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * User first name
   * @return firstName
  **/
  @Schema(required = true, description = "User first name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserItem lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * User last name
   * @return lastName
  **/
  @Schema(required = true, description = "User last name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserItem isLocked(Boolean isLocked) {
    this.isLocked = isLocked;
    return this;
  }

   /**
   * User is locked:  * &#x60;false&#x60; - unlocked  * &#x60;true&#x60; - locked    User is locked and can not login anymore.
   * @return isLocked
  **/
  @Schema(required = true, description = "User is locked:  * `false` - unlocked  * `true` - locked    User is locked and can not login anymore.")
  public Boolean isIsLocked() {
    return isLocked;
  }

  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }

  public UserItem hasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.27.0  User has manageable rooms
   * @return hasManageableRooms
  **/
  @Schema(description = "&#128679; Deprecated since v4.27.0  User has manageable rooms")
  public Boolean isHasManageableRooms() {
    return hasManageableRooms;
  }

  public void setHasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
  }

  public UserItem avatarUuid(String avatarUuid) {
    this.avatarUuid = avatarUuid;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Avatar UUID
   * @return avatarUuid
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  Avatar UUID")
  public String getAvatarUuid() {
    return avatarUuid;
  }

  public void setAvatarUuid(String avatarUuid) {
    this.avatarUuid = avatarUuid;
  }

  public UserItem createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Creation date
   * @return createdAt
  **/
  @Schema(description = "Creation date")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public UserItem lastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
    return this;
  }

   /**
   * Last successful logon date
   * @return lastLoginSuccessAt
  **/
  @Schema(description = "Last successful logon date")
  public DateTime getLastLoginSuccessAt() {
    return lastLoginSuccessAt;
  }

  public void setLastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
  }

  public UserItem expireAt(DateTime expireAt) {
    this.expireAt = expireAt;
    return this;
  }

   /**
   * Expiration date
   * @return expireAt
  **/
  @Schema(description = "Expiration date")
  public DateTime getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(DateTime expireAt) {
    this.expireAt = expireAt;
  }

  public UserItem isEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
    return this;
  }

   /**
   * User has generated private key.  Possible if client-side encryption is active for this customer
   * @return isEncryptionEnabled
  **/
  @Schema(description = "User has generated private key.  Possible if client-side encryption is active for this customer")
  public Boolean isIsEncryptionEnabled() {
    return isEncryptionEnabled;
  }

  public void setIsEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
  }

  public UserItem email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email 
   * @return email
  **/
  @Schema(description = "Email ")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserItem phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Phone number
   * @return phone
  **/
  @Schema(description = "Phone number")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserItem homeRoomId(Long homeRoomId) {
    this.homeRoomId = homeRoomId;
    return this;
  }

   /**
   * Homeroom ID
   * @return homeRoomId
  **/
  @Schema(description = "Homeroom ID")
  public Long getHomeRoomId() {
    return homeRoomId;
  }

  public void setHomeRoomId(Long homeRoomId) {
    this.homeRoomId = homeRoomId;
  }

  public UserItem userRoles(RoleList userRoles) {
    this.userRoles = userRoles;
    return this;
  }

   /**
   * Get userRoles
   * @return userRoles
  **/
  @Schema(description = "")
  public RoleList getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(RoleList userRoles) {
    this.userRoles = userRoles;
  }

  public UserItem userAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
    return this;
  }

   /**
   * Get userAttributes
   * @return userAttributes
  **/
  @Schema(description = "")
  public UserAttributes getUserAttributes() {
    return userAttributes;
  }

  public void setUserAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
  }

  public UserItem lockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.7.0  User lock status:  * &#x60;0&#x60; - locked  * &#x60;1&#x60; - Web access allowed  * &#x60;2&#x60; - Web and mobile access allowed    Please use &#x60;isLocked&#x60; instead.
   * @return lockStatus
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.7.0  User lock status:  * `0` - locked  * `1` - Web access allowed  * `2` - Web and mobile access allowed    Please use `isLocked` instead.")
  public Integer getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
  }

  public UserItem login(String login) {
    this.login = login;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.13.0  User login name
   * @return login
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.13.0  User login name")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public UserItem title(String title) {
    this.title = title;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.18.0  Job title
   * @return title
  **/
  @Schema(description = "&#128679; Deprecated since v4.18.0  Job title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UserItem gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.12.0  Gender
   * @return gender
  **/
  @Schema(description = "&#128679; Deprecated since v4.12.0  Gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserItem userItem = (UserItem) o;
    return Objects.equals(this.id, userItem.id) &&
        Objects.equals(this.userName, userItem.userName) &&
        Objects.equals(this.firstName, userItem.firstName) &&
        Objects.equals(this.lastName, userItem.lastName) &&
        Objects.equals(this.isLocked, userItem.isLocked) &&
        Objects.equals(this.hasManageableRooms, userItem.hasManageableRooms) &&
        Objects.equals(this.avatarUuid, userItem.avatarUuid) &&
        Objects.equals(this.createdAt, userItem.createdAt) &&
        Objects.equals(this.lastLoginSuccessAt, userItem.lastLoginSuccessAt) &&
        Objects.equals(this.expireAt, userItem.expireAt) &&
        Objects.equals(this.isEncryptionEnabled, userItem.isEncryptionEnabled) &&
        Objects.equals(this.email, userItem.email) &&
        Objects.equals(this.phone, userItem.phone) &&
        Objects.equals(this.homeRoomId, userItem.homeRoomId) &&
        Objects.equals(this.userRoles, userItem.userRoles) &&
        Objects.equals(this.userAttributes, userItem.userAttributes) &&
        Objects.equals(this.lockStatus, userItem.lockStatus) &&
        Objects.equals(this.login, userItem.login) &&
        Objects.equals(this.title, userItem.title) &&
        Objects.equals(this.gender, userItem.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, firstName, lastName, isLocked, hasManageableRooms, avatarUuid, createdAt, lastLoginSuccessAt, expireAt, isEncryptionEnabled, email, phone, homeRoomId, userRoles, userAttributes, lockStatus, login, title, gender);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
    sb.append("    hasManageableRooms: ").append(toIndentedString(hasManageableRooms)).append("\n");
    sb.append("    avatarUuid: ").append(toIndentedString(avatarUuid)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lastLoginSuccessAt: ").append(toIndentedString(lastLoginSuccessAt)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    isEncryptionEnabled: ").append(toIndentedString(isEncryptionEnabled)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    homeRoomId: ").append(toIndentedString(homeRoomId)).append("\n");
    sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
    sb.append("    userAttributes: ").append(toIndentedString(userAttributes)).append("\n");
    sb.append("    lockStatus: ").append(toIndentedString(lockStatus)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
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
