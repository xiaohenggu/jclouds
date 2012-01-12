/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.cloudstack.features;

import com.google.common.util.concurrent.ListenableFuture;
import org.jclouds.cloudstack.domain.Cluster;
import org.jclouds.cloudstack.domain.Host;
import org.jclouds.cloudstack.filters.QuerySigner;
import org.jclouds.cloudstack.options.AddHostOptions;
import org.jclouds.cloudstack.options.ListClustersOptions;
import org.jclouds.cloudstack.options.ListHostsOptions;
import org.jclouds.cloudstack.options.UpdateHostOptions;
import org.jclouds.rest.annotations.ExceptionParser;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.functions.ReturnEmptySetOnNotFoundOr404;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * Provides asynchronous access to cloudstack via their REST API.
 * <p/>
 *
 * @see GlobalHostClient
 * @see <a href="http://download.cloud.com/releases/2.2.0/api_2.2.12/TOC_Global_Admin.html" />
 * @author Andrei Savu
 */
@RequestFilters(QuerySigner.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalHostAsyncClient {

   /**
    * @see GlobalHostClient#listHosts
    */
   @GET
   @QueryParams(keys = "command", values = "listHosts")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnEmptySetOnNotFoundOr404.class)
   ListenableFuture<Set<Host>> listHosts(ListHostsOptions... options);

   /**
    * Adds a new host.
    *
    * @param zoneId the Zone ID for the host
    * @param url the host URL
    * @param hypervisor hypervisor type of the host
    * @param username the username for the host
    * @param password the password for the host
    * @param options optional arguments
    * @return the new host.
    */
   @GET
   @QueryParams(keys = "command", values = "addHost")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<Host> addHost(@QueryParam("zoneid") long zoneId, @QueryParam("url") String url, @QueryParam("hypervisor") String hypervisor, @QueryParam("username") String username, @QueryParam("password") String password, AddHostOptions... options);

   /**
    * Updates a host.
    *
    * @param hostId the ID of the host to update
    * @param options optional arguments
    * @return the modified host.
    */
   @GET
   @QueryParams(keys = "command", values = "updateHost")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<Host> updateHost(@QueryParam("id") long hostId, UpdateHostOptions... options);

   /**
    * Update password of a host on management server.
    *
    * @param hostId the host ID
    * @param username the username for the host
    * @param password the password for the host
    */
   @GET
   @QueryParams(keys = "command", values = "updateHostPassword")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<Void> updateHostPassword(@QueryParam("hostid") long hostId, @QueryParam("username") String username, @QueryParam("password") String password);

   /**
    * @see GlobalHostClient#listClusters
    */
   @GET
   @QueryParams(keys = "command", values = "listClusters")
   @SelectJson("cluster")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnEmptySetOnNotFoundOr404.class)
   ListenableFuture<Set<Cluster>> listClusters(ListClustersOptions... options);
}
