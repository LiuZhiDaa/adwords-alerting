// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awalerting;

import com.google.api.ads.adwords.awalerting.report.UnmodifiableReportRow;

/**
 * Alert actions are responsible for firing alerts and delivering them to approperiate destinations.
 *
 * This is the interface that every alert action should implement. Note that every implementation
 * MUST have a constructor with a JsonObject parameter for configuration.
 */
public interface AlertAction {
  /**
   * Perform initialization action before processing any report entry.
   */
  void initializeAction() throws AlertProcessingException;

  /**
   * Process a report entry. It could either perform some action here, or record some info
   * and perform some aggregated action in {@link #finalizeAction()} method.
   *
   * @param entry the unmodifiable report entry to process.
   */
  void processReportEntry(UnmodifiableReportRow entry) throws AlertProcessingException;

  /**
   * Perform finalization action after processing all report entries.
   */
  void finalizeAction() throws AlertProcessingException;
}
