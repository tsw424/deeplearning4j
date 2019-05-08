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

package org.nd4j.linalg.api.ops.impl.reduce.bp;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.ndarray.INDArray;


/**
 * Backprop op for Dot pairwise reduction operation
 *
 * @author Alex Black
 */

public class DotBp extends BaseReductionBp {

    public DotBp(SameDiff sameDiff, SDVariable origInput1, SDVariable origInput2, SDVariable gradAtOutput, boolean keepDims, int... dimensions) {
        super(sameDiff, origInput1, origInput2, gradAtOutput, keepDims, dimensions);
    }

    public DotBp(INDArray origInput1, INDArray origInput2, INDArray gradAtOutput, INDArray output, boolean keepDims, int... dimensions){
        super(origInput1, origInput2, gradAtOutput, output, keepDims, dimensions);
    }

    public DotBp(){}

    @Override
    public String opName() {
        return "reduce_dot_bp";
    }
}
