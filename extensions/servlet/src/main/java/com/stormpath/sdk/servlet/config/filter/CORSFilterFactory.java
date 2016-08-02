/*
 * Copyright 2016 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.servlet.config.filter;

import com.stormpath.sdk.servlet.authz.RequestAuthorizer;
import com.stormpath.sdk.servlet.config.Config;
import com.stormpath.sdk.servlet.filter.cors.CORSFilter;

import javax.servlet.ServletContext;

import static com.stormpath.sdk.servlet.config.impl.DefaultConfig.REQUEST_AUTHORIZER;

/**
 * @since 1.0.0
 */
public class CORSFilterFactory extends FilterFactory<CORSFilter> {

    @Override
    protected CORSFilter createInstance(ServletContext servletContext, Config config) throws Exception {

        RequestAuthorizer requestAuthorizer = config.getInstance(REQUEST_AUTHORIZER);
        CORSFilter filter = new CORSFilter();
        filter.setOriginRequestAuthorizer(requestAuthorizer);

        return filter;
    }
}
