/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.broker.client;

import io.netty.channel.Channel;
import org.apache.rocketmq.common.protocol.body.ProducerTableInfo;

public interface ProducerManagerInterface {

    int groupSize();

    boolean groupOnline(String group);

    ProducerTableInfo getProducerTable();

    void scanNotActiveChannel();

    boolean doChannelCloseEvent(String remoteAddr, Channel channel);

    void registerProducer(String group, ClientChannelInfo clientChannelInfo);

    void unregisterProducer(String group, ClientChannelInfo clientChannelInfo);

    Channel getAvailableChannel(String groupId);

    Channel findChannel(String clientId);

    void appendProducerChangeListener(ProducerChangeListener producerChangeListener);
}