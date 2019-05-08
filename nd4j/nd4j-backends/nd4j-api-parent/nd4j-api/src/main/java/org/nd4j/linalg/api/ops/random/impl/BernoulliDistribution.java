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

package org.nd4j.linalg.api.ops.random.impl;

import lombok.NonNull;
import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.base.Preconditions;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.random.BaseRandomOp;
import org.nd4j.linalg.exception.ND4JIllegalStateException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * BernoulliDistribution implementation
 *
 * @author raver119@gmail.com
 */
public class BernoulliDistribution extends BaseRandomOp {
    private double prob;

    public BernoulliDistribution(SameDiff sd, double prob, long[] shape){
        super(sd, shape);
        this.prob = prob;
        this.extraArgs = new Object[] {this.prob};
    }

    public BernoulliDistribution() {
        super();
    }

    /**
     * This op fills Z with bernoulli trial results, so 0, or 1, depending by common probability
     * @param z
    
     */
    public BernoulliDistribution(@NonNull INDArray z, double prob) {
        super(null, null, z);
        this.prob = prob;
        this.extraArgs = new Object[] {this.prob};
    }

    /**
     * This op fills Z with bernoulli trial results, so 0, or 1, each element will have it's own success probability defined in prob array
     * @param prob array with probabilities
     * @param z
    
     */
    public BernoulliDistribution(@NonNull INDArray z, @NonNull INDArray prob) {
        super(prob, null, z);
        if (prob.elementWiseStride() != 1)
            throw new ND4JIllegalStateException("Probabilities should have ElementWiseStride of 1");

        if (prob.length() != z.length())
            throw new ND4JIllegalStateException("Length of probabilities array [" + prob.length()
                            + "] doesn't match length of output array [" + z.length() + "]");
        this.prob = 0.0;
        this.extraArgs = new Object[] {this.prob};
    }

    @Override
    public int opNum() {
        return 7;
    }

    @Override
    public String opName() {
        return "distribution_bernoulli";
    }


    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }


    @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
        return Collections.emptyList(); //No SDVariable args
    }

    @Override
    public List<DataType> calculateOutputDataTypes(List<DataType> inputDataTypes){
        Preconditions.checkState(inputDataTypes == null || inputDataTypes.isEmpty(), "Expected no input datatypes (no args) for %s, got %s", getClass(), inputDataTypes);
        //Input data type specifies the shape; output data type should be any float
        //TODO MAKE CONFIGUREABLE - https://github.com/deeplearning4j/deeplearning4j/issues/6854
        return Collections.singletonList(DataType.DOUBLE);
    }
}
