/*******************************************************************************
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.autodiff.execution.conf;

/**
 * @author raver119@gmail.com
 */
public enum ExecutionMode {
    /**
     * all operations will be executed sequentially
     */
    SEQUENTIAL,

    /**
     * all operations will be following device id for execution mode selection
     */
    STRICT,

    /**
     * all operations that can be executed in parallel - will be executed in parallel
     */
    AUTO,
}
