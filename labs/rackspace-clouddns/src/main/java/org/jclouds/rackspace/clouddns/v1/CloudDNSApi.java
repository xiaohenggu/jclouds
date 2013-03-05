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
package org.jclouds.rackspace.clouddns.v1;

import org.jclouds.rackspace.clouddns.v1.features.LimitApi;
import org.jclouds.rest.annotations.Delegate;

/**
 * Provides access to the Rackspace Cloud DNS API.
 * <p/>
 * See <a href="http://docs.rackspace.com/cdns/api/v1.0/cdns-devguide/content/index.html">Cloud DNS Developer Guide</a> 
 * @see CloudDNSAsyncApi
 * @author Everett Toews
 */
public interface CloudDNSApi {
   /**
    * Provides synchronous access to Limit features.
    */
   @Delegate
   LimitApi getLimitApi();
}
