package swappingSchemes

class FifoCache[Key, Value] extends CacheTemplate[Key, Value] {
  def getValueIfExists(key: Key): Option[Value] = {
    cache.get(key)
  }
}