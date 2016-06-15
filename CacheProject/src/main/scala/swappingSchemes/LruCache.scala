package swappingSchemes

class LruCache[Key, Value] extends CacheTemplate[Key, Value] {
  def getValueIfExists(key: Key): Option[Value] = {
    if (cache.contains(key)) {
      moveToEnd(key)
    }
    cache.get(key)
  }
  def moveToEnd(key: Key) = {
    val value = cache.get(key).get
    cache -= key
    addPair(key, value)
  }
}