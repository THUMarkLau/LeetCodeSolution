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
package reorderdatainlogfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new LinkedList<>();
    for (String log : logs) {
      if (isDigit(log.split(" ")[1])) {
        digitLogs.add(log);
      } else {
        letterLogs.add(log);
      }
    }
    Map<String, String> remainCache = new HashMap<>();
    Map<String, String> identifierCache = new HashMap<>();
    letterLogs.sort(
        (o1, o2) -> {
          String remainOfO1 = remainCache.computeIfAbsent(o1, x -> x.substring(x.indexOf(' ')));
          String remainOfO2 = remainCache.computeIfAbsent(o2, x -> x.substring(x.indexOf(' ')));
          if (remainOfO1.equals(remainOfO2)) {
            return identifierCache
                .computeIfAbsent(o1, x -> x.substring(0, x.indexOf(' ')))
                .compareTo(
                    identifierCache.computeIfAbsent(o2, x -> x.substring(0, x.indexOf(' '))));
          } else {
            return remainOfO1.compareTo(remainOfO2);
          }
        });
    letterLogs.addAll(digitLogs);

    return letterLogs.toArray(new String[] {});
  }

  private boolean isDigit(String log) {
    for (char c : log.toCharArray()) {
      if (!(c >= '0' && c <= '9')) {
        return false;
      }
    }
    return true;
  }
}
