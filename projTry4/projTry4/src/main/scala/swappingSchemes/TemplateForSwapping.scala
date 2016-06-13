package swappingSchemes

import package1.{ActiveCache, CacheElement}

trait TemplateForSwapping {
  def updateTimestamp()
  def valueToDelete(cache: ActiveCache): Long
}
