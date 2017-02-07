import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		Dictionary<String, Integer> occurences = new Hashtable<String, Integer>();

		String stringKey = key.toString();
		for (IntWritable value: values) {
			Integer currentOccurences = occurences.get(stringKey);
			if (currentOccurences == null) {
				occurences.put(stringKey, 1);
				continue;
			}
			occurences.put(stringKey, currentOccurences + 1);
		}

		Integer totalOccurences = occurences.get(stringKey);
		if (totalOccurences == null) {
			context.write(key, new IntWritable(0));
		} else {
			context.write(key, new IntWritable(totalOccurences));
		}

		
	}
}
