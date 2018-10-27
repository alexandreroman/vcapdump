/*
 * Copyright (c) 2018 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.alexandreroman.demos.vcapdump

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * REST controller showing the content of VCAP_SERVICES.
 */
@RestController
class VcapDumpController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/")
    fun getDump(): ResponseEntity<JsonNode> {
        val vcapEnv: String? = System.getenv("VCAP_SERVICES")
        if (vcapEnv.isNullOrEmpty()) {
            logger.warn("VCAP_SERVICES is not set")
            return ResponseEntity.noContent().build()
        }

        val vcapJson = jacksonObjectMapper().readValue(vcapEnv, JsonNode::class.java)
        return ResponseEntity.ok(vcapJson)
    }
}
