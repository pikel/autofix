/*
 * Copyright 2001-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test

import org.scalatest._
import prop._
import scala.collection.immutable._
import java.util.NoSuchElementException
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpecLike

class ReplacePropSpecLike extends AnyPropSpecLike with TableDrivenPropertyChecks with Matchers {

  val examples =
    Table(
      "set",
      BitSet.empty,
      HashSet.empty[Int],
      TreeSet.empty[Int]
    )
  
  property("an empty Set should have size 0") {
    forAll(examples) { set =>
      set.size should be (0)
    }
  }

  property("invoking head on an empty set should produce NoSuchElementException") {
    forAll(examples) { set =>
      a [NoSuchElementException] should be thrownBy { set.head }
    }
  }
}

