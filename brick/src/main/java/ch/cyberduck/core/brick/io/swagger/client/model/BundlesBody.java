/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
/**
 * BundlesBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-23T20:47:00.742522+02:00[Europe/Paris]")
public class BundlesBody {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("paths")
  private List<String> paths = new ArrayList<>();

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("form_field_set_id")
  private Integer formFieldSetId = null;

  @JsonProperty("expires_at")
  private DateTime expiresAt = null;

  @JsonProperty("max_uses")
  private Integer maxUses = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("note")
  private String note = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("preview_only")
  private Boolean previewOnly = null;

  @JsonProperty("require_registration")
  private Boolean requireRegistration = null;

  @JsonProperty("clickwrap_id")
  private Integer clickwrapId = null;

  @JsonProperty("inbox_id")
  private Integer inboxId = null;

  @JsonProperty("require_share_recipient")
  private Boolean requireShareRecipient = null;

  public BundlesBody userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID.  Provide a value of &#x60;0&#x60; to operate the current session&#x27;s user.
   * @return userId
  **/
  @Schema(description = "User ID.  Provide a value of `0` to operate the current session's user.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BundlesBody paths(List<String> paths) {
    this.paths = paths;
    return this;
  }

  public BundlesBody addPathsItem(String pathsItem) {
    this.paths.add(pathsItem);
    return this;
  }

   /**
   * A list of paths to include in this bundle.
   * @return paths
  **/
  @Schema(example = "[\"file.txt\"]", required = true, description = "A list of paths to include in this bundle.")
  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(List<String> paths) {
    this.paths = paths;
  }

  public BundlesBody password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password for this bundle.
   * @return password
  **/
  @Schema(example = "Password", description = "Password for this bundle.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public BundlesBody formFieldSetId(Integer formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
    return this;
  }

   /**
   * Id of Form Field Set to use with this bundle
   * @return formFieldSetId
  **/
  @Schema(description = "Id of Form Field Set to use with this bundle")
  public Integer getFormFieldSetId() {
    return formFieldSetId;
  }

  public void setFormFieldSetId(Integer formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
  }

  public BundlesBody expiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * Bundle expiration date/time
   * @return expiresAt
  **/
  @Schema(description = "Bundle expiration date/time")
  public DateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public BundlesBody maxUses(Integer maxUses) {
    this.maxUses = maxUses;
    return this;
  }

   /**
   * Maximum number of times bundle can be accessed
   * @return maxUses
  **/
  @Schema(example = "1", description = "Maximum number of times bundle can be accessed")
  public Integer getMaxUses() {
    return maxUses;
  }

  public void setMaxUses(Integer maxUses) {
    this.maxUses = maxUses;
  }

  public BundlesBody description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Public description
   * @return description
  **/
  @Schema(example = "The public description of the bundle.", description = "Public description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BundlesBody note(String note) {
    this.note = note;
    return this;
  }

   /**
   * Bundle internal note
   * @return note
  **/
  @Schema(example = "The internal note on the bundle.", description = "Bundle internal note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public BundlesBody code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Bundle code.  This code forms the end part of the Public URL.
   * @return code
  **/
  @Schema(example = "abc123", description = "Bundle code.  This code forms the end part of the Public URL.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BundlesBody previewOnly(Boolean previewOnly) {
    this.previewOnly = previewOnly;
    return this;
  }

   /**
   * Restrict users to previewing files only?
   * @return previewOnly
  **/
  @Schema(description = "Restrict users to previewing files only?")
  public Boolean isPreviewOnly() {
    return previewOnly;
  }

  public void setPreviewOnly(Boolean previewOnly) {
    this.previewOnly = previewOnly;
  }

  public BundlesBody requireRegistration(Boolean requireRegistration) {
    this.requireRegistration = requireRegistration;
    return this;
  }

   /**
   * Show a registration page that captures the downloader&#x27;s name and email address?
   * @return requireRegistration
  **/
  @Schema(description = "Show a registration page that captures the downloader's name and email address?")
  public Boolean isRequireRegistration() {
    return requireRegistration;
  }

  public void setRequireRegistration(Boolean requireRegistration) {
    this.requireRegistration = requireRegistration;
  }

  public BundlesBody clickwrapId(Integer clickwrapId) {
    this.clickwrapId = clickwrapId;
    return this;
  }

   /**
   * ID of the clickwrap to use with this bundle.
   * @return clickwrapId
  **/
  @Schema(example = "1", description = "ID of the clickwrap to use with this bundle.")
  public Integer getClickwrapId() {
    return clickwrapId;
  }

  public void setClickwrapId(Integer clickwrapId) {
    this.clickwrapId = clickwrapId;
  }

  public BundlesBody inboxId(Integer inboxId) {
    this.inboxId = inboxId;
    return this;
  }

   /**
   * ID of the associated inbox, if available.
   * @return inboxId
  **/
  @Schema(example = "1", description = "ID of the associated inbox, if available.")
  public Integer getInboxId() {
    return inboxId;
  }

  public void setInboxId(Integer inboxId) {
    this.inboxId = inboxId;
  }

  public BundlesBody requireShareRecipient(Boolean requireShareRecipient) {
    this.requireShareRecipient = requireShareRecipient;
    return this;
  }

   /**
   * Only allow access to recipients who have explicitly received the share via an email sent through the Files.com UI?
   * @return requireShareRecipient
  **/
  @Schema(description = "Only allow access to recipients who have explicitly received the share via an email sent through the Files.com UI?")
  public Boolean isRequireShareRecipient() {
    return requireShareRecipient;
  }

  public void setRequireShareRecipient(Boolean requireShareRecipient) {
    this.requireShareRecipient = requireShareRecipient;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundlesBody bundlesBody = (BundlesBody) o;
    return Objects.equals(this.userId, bundlesBody.userId) &&
        Objects.equals(this.paths, bundlesBody.paths) &&
        Objects.equals(this.password, bundlesBody.password) &&
        Objects.equals(this.formFieldSetId, bundlesBody.formFieldSetId) &&
        Objects.equals(this.expiresAt, bundlesBody.expiresAt) &&
        Objects.equals(this.maxUses, bundlesBody.maxUses) &&
        Objects.equals(this.description, bundlesBody.description) &&
        Objects.equals(this.note, bundlesBody.note) &&
        Objects.equals(this.code, bundlesBody.code) &&
        Objects.equals(this.previewOnly, bundlesBody.previewOnly) &&
        Objects.equals(this.requireRegistration, bundlesBody.requireRegistration) &&
        Objects.equals(this.clickwrapId, bundlesBody.clickwrapId) &&
        Objects.equals(this.inboxId, bundlesBody.inboxId) &&
        Objects.equals(this.requireShareRecipient, bundlesBody.requireShareRecipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, paths, password, formFieldSetId, expiresAt, maxUses, description, note, code, previewOnly, requireRegistration, clickwrapId, inboxId, requireShareRecipient);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundlesBody {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    formFieldSetId: ").append(toIndentedString(formFieldSetId)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    maxUses: ").append(toIndentedString(maxUses)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    previewOnly: ").append(toIndentedString(previewOnly)).append("\n");
    sb.append("    requireRegistration: ").append(toIndentedString(requireRegistration)).append("\n");
    sb.append("    clickwrapId: ").append(toIndentedString(clickwrapId)).append("\n");
    sb.append("    inboxId: ").append(toIndentedString(inboxId)).append("\n");
    sb.append("    requireShareRecipient: ").append(toIndentedString(requireShareRecipient)).append("\n");
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
