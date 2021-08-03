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
/**
 * Request model for testing connection for Active Directory configuration
 */
@Schema(description = "Request model for testing connection for Active Directory configuration")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T23:34:01.480829+02:00[Europe/Paris]")
public class TestActiveDirectoryConfigRequest {
  @JsonProperty("serverIp")
  private String serverIp = null;

  @JsonProperty("serverPort")
  private Integer serverPort = null;

  @JsonProperty("serverAdminName")
  private String serverAdminName = null;

  @JsonProperty("serverAdminPassword")
  private String serverAdminPassword = null;

  @JsonProperty("ldapUsersDomain")
  private String ldapUsersDomain = null;

  @JsonProperty("useLdaps")
  private Boolean useLdaps = false;

  @JsonProperty("sslFingerPrint")
  private String sslFingerPrint = null;

  public TestActiveDirectoryConfigRequest serverIp(String serverIp) {
    this.serverIp = serverIp;
    return this;
  }

   /**
   * IPv4 or IPv6 address or host name
   * @return serverIp
  **/
  @Schema(required = true, description = "IPv4 or IPv6 address or host name")
  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public TestActiveDirectoryConfigRequest serverPort(Integer serverPort) {
    this.serverPort = serverPort;
    return this;
  }

   /**
   * Port
   * @return serverPort
  **/
  @Schema(required = true, description = "Port")
  public Integer getServerPort() {
    return serverPort;
  }

  public void setServerPort(Integer serverPort) {
    this.serverPort = serverPort;
  }

  public TestActiveDirectoryConfigRequest serverAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
    return this;
  }

   /**
   * Distinguished Name (DN) of Active Directory administrative account
   * @return serverAdminName
  **/
  @Schema(required = true, description = "Distinguished Name (DN) of Active Directory administrative account")
  public String getServerAdminName() {
    return serverAdminName;
  }

  public void setServerAdminName(String serverAdminName) {
    this.serverAdminName = serverAdminName;
  }

  public TestActiveDirectoryConfigRequest serverAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
    return this;
  }

   /**
   * Password of Active Directory administrative account
   * @return serverAdminPassword
  **/
  @Schema(required = true, description = "Password of Active Directory administrative account")
  public String getServerAdminPassword() {
    return serverAdminPassword;
  }

  public void setServerAdminPassword(String serverAdminPassword) {
    this.serverAdminPassword = serverAdminPassword;
  }

  public TestActiveDirectoryConfigRequest ldapUsersDomain(String ldapUsersDomain) {
    this.ldapUsersDomain = ldapUsersDomain;
    return this;
  }

   /**
   * Search scope of Active Directory; only users below this node can log on.
   * @return ldapUsersDomain
  **/
  @Schema(required = true, description = "Search scope of Active Directory; only users below this node can log on.")
  public String getLdapUsersDomain() {
    return ldapUsersDomain;
  }

  public void setLdapUsersDomain(String ldapUsersDomain) {
    this.ldapUsersDomain = ldapUsersDomain;
  }

  public TestActiveDirectoryConfigRequest useLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
    return this;
  }

   /**
   * Determines whether LDAPS should be used instead of plain LDAP.
   * @return useLdaps
  **/
  @Schema(description = "Determines whether LDAPS should be used instead of plain LDAP.")
  public Boolean isUseLdaps() {
    return useLdaps;
  }

  public void setUseLdaps(Boolean useLdaps) {
    this.useLdaps = useLdaps;
  }

  public TestActiveDirectoryConfigRequest sslFingerPrint(String sslFingerPrint) {
    this.sslFingerPrint = sslFingerPrint;
    return this;
  }

   /**
   * SSL finger print of Active Directory server.  Mandatory for LDAPS connections.  Format: &#x60;Algorithm/Fingerprint&#x60;
   * @return sslFingerPrint
  **/
  @Schema(description = "SSL finger print of Active Directory server.  Mandatory for LDAPS connections.  Format: `Algorithm/Fingerprint`")
  public String getSslFingerPrint() {
    return sslFingerPrint;
  }

  public void setSslFingerPrint(String sslFingerPrint) {
    this.sslFingerPrint = sslFingerPrint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestActiveDirectoryConfigRequest testActiveDirectoryConfigRequest = (TestActiveDirectoryConfigRequest) o;
    return Objects.equals(this.serverIp, testActiveDirectoryConfigRequest.serverIp) &&
        Objects.equals(this.serverPort, testActiveDirectoryConfigRequest.serverPort) &&
        Objects.equals(this.serverAdminName, testActiveDirectoryConfigRequest.serverAdminName) &&
        Objects.equals(this.serverAdminPassword, testActiveDirectoryConfigRequest.serverAdminPassword) &&
        Objects.equals(this.ldapUsersDomain, testActiveDirectoryConfigRequest.ldapUsersDomain) &&
        Objects.equals(this.useLdaps, testActiveDirectoryConfigRequest.useLdaps) &&
        Objects.equals(this.sslFingerPrint, testActiveDirectoryConfigRequest.sslFingerPrint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverIp, serverPort, serverAdminName, serverAdminPassword, ldapUsersDomain, useLdaps, sslFingerPrint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestActiveDirectoryConfigRequest {\n");
    
    sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
    sb.append("    serverPort: ").append(toIndentedString(serverPort)).append("\n");
    sb.append("    serverAdminName: ").append(toIndentedString(serverAdminName)).append("\n");
    sb.append("    serverAdminPassword: ").append(toIndentedString(serverAdminPassword)).append("\n");
    sb.append("    ldapUsersDomain: ").append(toIndentedString(ldapUsersDomain)).append("\n");
    sb.append("    useLdaps: ").append(toIndentedString(useLdaps)).append("\n");
    sb.append("    sslFingerPrint: ").append(toIndentedString(sslFingerPrint)).append("\n");
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
