/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.component.model;

import org.gradle.api.internal.artifacts.ivyservice.resolveengine.excludes.ModuleExclusion;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConfigurationMetadata {
    /**
     * The set of configurations that this configuration extends. Includes this configuration.
     */
    Set<String> getHierarchy();

    String getName();

    /**
     * Returns the dependencies that apply to this configuration.
     */
    List<DependencyMetadata> getDependencies();

    /**
     * Returns the artifacts associated with this configuration, if known.
     */
    Set<ComponentArtifactMetadata> getArtifacts();

    /**
     * Returns the exclusions to apply to outgoing dependencies from this configuration.
     */
    ModuleExclusion getExclusions();

    boolean isTransitive();

    boolean isVisible();

    boolean isConsumeOrPublishAllowed();

    boolean isQueryOrResolveAllowed();

    Map<String, String> getAttributes();

    /**
     * Find the component artifact with the given IvyArtifactName, creating a new one if none matches.
     *
     * This is used to create a ComponentArtifactMetadata from an artifact declared as part of a dependency.
     * The reason to do this lookup is that for a local component artifact, the file is part of the artifact metadata.
     * (For external module components, we just instantiate a new artifact metadata).
     */
    ComponentArtifactMetadata artifact(IvyArtifactName artifact);

}
