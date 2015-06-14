package chapter7.task1

/**
 * ObjectInPackageChain <Description>
 *
 * @author vadya
 */

package com.horstmann {
  object ObjectInOuterScope {
    override def toString = s"ObjectInOuterScope()"
  }
}

package com.horstmann.impatient {

  import com.horstmann.ObjectInOuterScope // chained package declaration requires explicit import of items from
  // outer packages

  object ObjectInPackageChain {
    override def toString: String = getClass.getName + " is at " + getClass.getPackage.getName +
      " accessing " + ObjectInOuterScope
  }
}

package com { // nested packages see contents of outer packages without import
  package horstmann {
    package impatient {
      object ObjectInLastPackage {
        override def toString: String = getClass.getName + " is at " + getClass.getPackage.getName +
          " accessing " + ObjectInOuterScope
      }
    }
  }
}
