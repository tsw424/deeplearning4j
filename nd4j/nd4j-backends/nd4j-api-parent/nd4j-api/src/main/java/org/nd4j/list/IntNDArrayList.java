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

package org.nd4j.list;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * An {@link BaseNDArrayList} for integers
 *
 * @author Adam Gibson
 */
public class IntNDArrayList extends BaseNDArrayList<Integer> {
    public IntNDArrayList() {
    }

    public IntNDArrayList(INDArray container) {
        super(container);
    }


    @Override
    public Integer get(int i) {
        Number ret = container.getDouble(i);
        return ret.intValue();
    }


}
