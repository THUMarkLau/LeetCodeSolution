/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package numberofrecentcalls;

import java.util.LinkedList;

class RecentCounter {
  LinkedList<Integer> callRecordList = new LinkedList<>();

  public RecentCounter() {}

  public int ping(int t) {
    callRecordList.add(t);
    if (callRecordList.size() == 1) {
      return 1;
    }
    while (callRecordList.getFirst() < t - 3000) {
      callRecordList.removeFirst();
    }
    return callRecordList.size();
  }

  public static void main(String[] args) {
    RecentCounter counter = new RecentCounter();
    System.out.println(counter.ping(1));
    System.out.println(counter.ping(100));
    System.out.println(counter.ping(3001));
    System.out.println(counter.ping(3002));
  }
}
