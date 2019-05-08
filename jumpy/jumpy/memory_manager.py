################################################################################
# Copyright (c) 2015-2019 Skymind, Inc.
#
# This program and the accompanying materials are made available under the
# terms of the Apache License, Version 2.0 which is available at
# https://www.apache.org/licenses/LICENSE-2.0.
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations
# under the License.
#
# SPDX-License-Identifier: Apache-2.0
################################################################################


from .java_classes import Nd4j

memory_manager = Nd4j.getMemoryManager()


def disable_gc():
    memory_manager.togglePeriodicGc(False)


def enable_gc():
    memory_manager.togglePeriodicGc(True)


def set_gc_interval(interval=5000):
    memory_manager.setAutoGcWindow(interval)
