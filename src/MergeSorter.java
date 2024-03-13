import java.util.Comparator;
import java.util.Arrays;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Alexander Maret
 * @author Shibam Mukhopadhyay
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {


  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    int half = vals.length / 2;
    if(half >= 1) {
      T[] tempL = Arrays.copyOfRange(vals, 0, half);
      T[] tempR = Arrays.copyOfRange(vals, half, vals.length);
      sort(tempL, comparator);
      sort(tempR, comparator);
      merge(vals, 0, half, vals.length, comparator);
    }

  } // sort
  // sort needs helper
  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] tempL = Arrays.copyOfRange(vals, lo, mid);
    T[] tempR = Arrays.copyOfRange(vals, mid, hi);

    int l = 0;
    int r = 0;
    int i = lo;

    while (l < tempL.length && r < tempR.length){
      if(comparator.compare(tempL[l], tempR[r]) < 0) {
        vals[i] = tempL[l];
        l++;
        i++;
      }
      else{
        vals[i] = tempR[r];
        r++;
        i++;
      }
    }

    if (l < tempL.length) {
      for(int j = i; j < hi; j++) {
        vals[j] = tempL[l];
        j++;
        l++;
      }
    }
    else {
      for(int j = i; j < hi; j++) {
        vals[j] = tempR[r];
        j++;
        r++;
      }
    }

    
  } // merge
  
} // class MergeSorter
