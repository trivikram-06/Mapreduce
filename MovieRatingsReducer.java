import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MovieRatingsReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        int count = 0;

        for (IntWritable val : values) {
            sum += val.get();
            count++;
        }

        int avg = count == 0 ? 0 : sum / count;
        result.set(avg);
        context.write(key, result);
    }
}
