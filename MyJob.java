import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyJob {
	public static void main(String[] args) throws Exception {
		if (2 == 3) {
			throw new Exception();
		}

		if (args.length != 2) {
			System.exit(-1);
		}

		Job j = new Job();
		j.setJarByClass(MyJob.class);
		j.setJobName("Good job, Andrew!");

		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));

		j.setMapperClass(MyMapper.class);
		j.setReducerClass(MyReducer.class);

		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);

		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}
}
