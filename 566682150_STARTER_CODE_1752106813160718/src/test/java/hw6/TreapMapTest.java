package hw6;

import hw6.bst.TreapMap;

/**
 * In addition to the tests in BinarySearchTreeMapTest (and in OrderedMapTest & MapTest),
 * we add tests specific to Treap.
 */
@SuppressWarnings("All")
public class TreapMapTest extends BinarySearchTreeMapTest {

  /**
   *   added seed to random for genarated same values
   */
  @Override
  protected Map<String, String> createMap() {
    return new TreapMap<>(47);
  }

}