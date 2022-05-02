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
package tagvalidator;

import java.util.Stack;

public class Solution {
  private String code;
  private int currIndex = 0;
  private String currToken = null;
  private TokenType currTokenType = null;
  private boolean valid = true;
  private Stack<String> startTagStack = new Stack<>();
  private boolean start = false;

  public boolean isValid(String code) {
    this.code = code;
    int codeLength = code.length();
    while (currIndex < codeLength && this.valid) {
      getNextToken();
      processToken();
    }
    this.valid = this.valid && startTagStack.size() == 0;
    return this.valid;
  }

  private void getNextToken() {
    StringBuilder tokenBuilder = new StringBuilder();
    currTokenType = TokenType.INVALID;
    switch (code.charAt(currIndex)) {
      case '<':
        tokenBuilder.append('<');
        currIndex++;
        if (currIndex < code.length()) {
          if (code.startsWith("/", currIndex)) {
            // endTag
            while (currIndex < code.length() && code.charAt(currIndex) != '>') {
              tokenBuilder.append(code.charAt(currIndex++));
            }
            if (currIndex < code.length()) {
              tokenBuilder.append(code.charAt(currIndex++));
              currTokenType = TokenType.END_TAG;
            }
          } else if (code.startsWith("![CDATA[", currIndex)) {
            // cdata
            while (currIndex < code.length() && !code.startsWith("]]>", currIndex)) {
              tokenBuilder.append(code.charAt(currIndex++));
            }
            if (currIndex < code.length()) {
              tokenBuilder.append("]]>");
              currIndex += 3;
              currTokenType = TokenType.CDATA;
            }
          } else {
            // startTag
            while (currIndex < code.length() && code.charAt(currIndex) != '>') {
              tokenBuilder.append(code.charAt(currIndex++));
            }
            if (currIndex < code.length()) {
              tokenBuilder.append(code.charAt(currIndex++));
              currTokenType = TokenType.START_TAG;
            }
          }
        }
        break;
      default:
        while (currIndex < code.length() && code.charAt(currIndex) != '<') {
          tokenBuilder.append(code.charAt(currIndex++));
        }
        currTokenType = TokenType.CONTENT;
    }
    currToken = tokenBuilder.toString();
  }

  private void processToken() {
    if (!this.valid) {
      return;
    }
    switch (currTokenType) {
      case START_TAG:
        this.valid = !this.start || this.startTagStack.size() > 0;
        this.start = true;
        startTagStack.push(currToken);
        break;
      case END_TAG:
        if (this.startTagStack.size() == 0) {
          this.valid = false;
        } else {
          String prevToken = startTagStack.pop();
          this.valid = validTag(prevToken, currToken);
        }
        break;
      case INVALID:
        this.valid = false;
        break;
      case CDATA:
      case CONTENT:
        // CDATA and CONTENT should be surrounded by tag
        this.valid = this.startTagStack.size() > 0;
        break;
    }
  }

  private boolean validTag(String startTag, String endTag) {
    if (!startTag.startsWith("<") || !startTag.endsWith(">")) {
      return false;
    }
    String startContent = startTag.substring(1, startTag.length() - 1);
    if (!endTag.startsWith("</") || !endTag.endsWith(">")) {
      return false;
    }
    String endContent = endTag.substring(2, endTag.length() - 1);
    return validTagContent(startContent, endContent);
  }

  private boolean validTagContent(String startTagContent, String endTagContent) {
    for (Character c : startTagContent.toCharArray()) {
      if (!(c <= 'Z' && c >= 'A')) {
        return false;
      }
    }
    return startTagContent.length() >= 1
        && startTagContent.length() <= 9
        && startTagContent.equals(endTagContent);
  }

  private enum TokenType {
    START_TAG,
    END_TAG,
    CONTENT,
    CDATA,
    INVALID
  }
}
