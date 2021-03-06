/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.galasaecosystem;

import java.util.Properties;

import javax.validation.constraints.NotNull;

import com.google.gson.JsonObject;

/**
 * Kubernetes Ecosystem TPI
 * 
 * Provides access to the ecosystem endpoints and provides the mean to manipulate the ecosystem
 *  
 * @author Michael Baylis
 *
 */
public interface IKubernetesEcosystem {
    
    /**
     * @param endpoint {@link EcosystemEndpoint} Which endpoint is required
     * @return Object of the endpoint, never null, URL, URI or InetSocketAddress
     * @throws GalasaEcosystemManagerException If the endpoint is unsupported
     */
    public @NotNull Object getEndpoint(@NotNull EcosystemEndpoint endpoint) throws GalasaEcosystemManagerException;
        
    /**
     * Retrieve a CPS property
     * 
     * @param property The property to retrieve
     * @return the value of the property or null if not found
     * @throws GalasaEcosystemManagerException if there is a problem accessing the CPS
     */
    public String getCpsProperty(@NotNull String property) throws GalasaEcosystemManagerException;
    
    /**
     * Set a CPS property
     * 
     * @param property The property to set
     * @param value The value to set, null means delete
     * @throws GalasaEcosystemManagerException if there is a problem accessing the CPS
     */
    public void setCpsProperty(@NotNull String property, String value)  throws GalasaEcosystemManagerException;
    
    /**
     * Retrieve a DSS property
     * 
     * @param property The property to retrieve
     * @return the value of the property or null if not found
     * @throws GalasaEcosystemManagerException if there is a problem accessing the DSS
     */
    public String getDssProperty(@NotNull String property) throws GalasaEcosystemManagerException;
    
    /**
     * Set a DSS property
     * 
     * @param property The property to set
     * @param value The value to set, null means delete
     * @throws GalasaEcosystemManagerException if there is a problem accessing the DSS
     */
    public void setDssProperty(@NotNull String property, String value)  throws GalasaEcosystemManagerException;
    
    /**
     * Retrieve a CREDS property
     * 
     * @param property The property to retrieve
     * @return the value of the property or null if not found
     * @throws GalasaEcosystemManagerException if there is a problem accessing the CREDS
     */
    public String getCredsProperty(@NotNull String property) throws GalasaEcosystemManagerException;
    
    /**
     * Set a CREDS property
     * 
     * @param property The property to set
     * @param value The value to set, null means delete
     * @throws GalasaEcosystemManagerException if there is a problem accessing the CREDS
     */
    public void setCredsProperty(@NotNull String property, String value)  throws GalasaEcosystemManagerException;
    
    public void submitRun(String runType,
                          String requestor,
                          String groupName,
                          @NotNull String bundleName,
                          @NotNull String testName,
                          String mavenRepository,
                          String obr,
                          String stream,
                          Properties overrides) throws GalasaEcosystemManagerException;

    public JsonObject getSubmittedRuns(String groupName) throws GalasaEcosystemManagerException;

    public JsonObject waitForGroupNames(String groupName, long timeout) throws GalasaEcosystemManagerException; 
    
}