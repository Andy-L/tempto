/*
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
package com.teradata.tempto.internal.initialization.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.teradata.tempto.configuration.Configuration;
import com.teradata.tempto.initialization.AutoModuleProvider;
import com.teradata.tempto.internal.TestInfo;
import com.teradata.tempto.initialization.TestMethodModuleProvider;
import org.testng.ITestResult;

@AutoModuleProvider
public class TestMethodInfoModuleProvider
        implements TestMethodModuleProvider
{
    public Module getModule(Configuration configuration, ITestResult testResult)
    {
        TestInfo testInfo = new TestInfo(testResult);
        return new AbstractModule()
        {
            @Override
            protected void configure()
            {
                bind(TestInfo.class).toInstance(testInfo);
            }
        };
    }
}
