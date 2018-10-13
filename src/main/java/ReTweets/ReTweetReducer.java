package ReTweets;




import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
public class ReTweetReducer extends Reducer<Text, IntWritable,Text,Text>{

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        //super.reduce(key, values, context);

        // key is the abreviation of a state
        // values is a list of 1s, one for each school found for the state

        // setup a counter
        String rtweet = "";
        // iterator over list of 1s, to count them (no size() or length() method available)
        for (IntWritable value : values ){
            rtweet+= value.toString()+" \n";
        }
        // emit key-pair: key, count
        // key is the abreviation for the state
        // count is the number of schools in the state

        //logger.trace("Red: " + key.toString());

        // DEBUG
        context.write(key, new Text(rtweet));
    }
}





