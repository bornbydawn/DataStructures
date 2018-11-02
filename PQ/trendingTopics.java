
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

import java.awt.print.Printable;

class Topic {

    long topicId;
    long oldZScore;
    long newZScore;
    long posts;
    long likes;
    long comments;
    long shares;

    public Topic(long topicId, long oldZScore, long posts, long likes, long comments, long shares) {
        this.topicId = topicId;
        this.oldZScore = oldZScore;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    public void setNewZScore(long newZScore) {
        this.newZScore = newZScore;
    }
}

class TopicComparator implements Comparator<Topic> {
    public int compare(Topic t1, Topic t2) {
        if ((t1.newZScore - t1.oldZScore) > (t2.newZScore - t2.oldZScore)) {

            return 1;

        } else {

            if ((t1.newZScore - t1.oldZScore) == (t2.newZScore - t2.oldZScore)) {
                if (t1.topicId > t2.topicId)
                    return 1;
                else
                    return -1;
            }

            else
                return -1;
        }
    }
}

class Main {

    public static void topFive(PriorityQueue<Topic> pq) {

        ArrayList<Topic> finalList = new ArrayList<Topic>(5);

        while (!pq.isEmpty()) {
            Topic topic = pq.poll();
            //always add element to the starting so the remaining elements are pushed back, its like adding elements in the reverse order
            finalList.add(0,topic);
            
        }

        //Collections.reverse(finalList);
        

        for (Topic topic : finalList) {
            System.out.print(topic.topicId + " " + topic.newZScore);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        FastReader s = new FastReader();

        int length = s.nextInt();

        long newZScore;
        ArrayList<Topic> topics = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {

            newZScore = 0;

            long topicId = s.nextLong();
            long oldZScore = s.nextLong();
            long posts = s.nextLong();
            long likes = s.nextLong();
            long comments = s.nextLong();
            long shares = s.nextLong();

            Topic topic = new Topic(topicId, oldZScore, posts, likes, comments, shares);

            newZScore = posts * 50 + likes * 5 + comments * 10 + shares * 20;
            topic.setNewZScore(newZScore);

            topics.add(topic);
        }

        PriorityQueue<Topic> pq = new PriorityQueue<>(5, new TopicComparator());

        for (int i = 0; i < length; i++) {

            if (i < 5) {
                pq.add(topics.get(i));
            }

            else {
                Topic atTop = pq.peek();
                Topic thisTopic = topics.get(i);
                if (pq.comparator().compare(thisTopic, atTop) > 0) {

                    pq.remove();
                    pq.add(thisTopic);
                }

            }

        }
        topFive(pq);

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
