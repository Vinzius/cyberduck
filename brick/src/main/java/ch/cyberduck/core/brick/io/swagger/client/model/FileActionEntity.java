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
/**
 * Move file/folder
 */
@Schema(description = "Move file/folder")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class FileActionEntity {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("file_migration_id")
  private Integer fileMigrationId = null;

  public FileActionEntity status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of file operation. Possible values: completed, enqueued.
   * @return status
  **/
  @Schema(example = "enqueued", description = "Status of file operation. Possible values: completed, enqueued.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public FileActionEntity fileMigrationId(Integer fileMigrationId) {
    this.fileMigrationId = fileMigrationId;
    return this;
  }

   /**
   * If status is enqueued, this is the id of the FileMigration to check for status updates.
   * @return fileMigrationId
  **/
  @Schema(example = "123", description = "If status is enqueued, this is the id of the FileMigration to check for status updates.")
  public Integer getFileMigrationId() {
    return fileMigrationId;
  }

  public void setFileMigrationId(Integer fileMigrationId) {
    this.fileMigrationId = fileMigrationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileActionEntity fileActionEntity = (FileActionEntity) o;
    return Objects.equals(this.status, fileActionEntity.status) &&
        Objects.equals(this.fileMigrationId, fileActionEntity.fileMigrationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, fileMigrationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileActionEntity {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    fileMigrationId: ").append(toIndentedString(fileMigrationId)).append("\n");
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