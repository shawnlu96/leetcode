package com.sunstriker.leetcode;

import java.util.*;

public class L355设计推特 {
    public static void main(String[] args) {
        var t=  new Twitter();
        t.postTweet(1,5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1,2);
        t.postTweet(2,6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1,2);
        System.out.println(t.getNewsFeed(1));
    }
    static class Twitter {
        static int timestamp = 0;

        static class Tweet {
            int id;
            int time;
            Tweet next;

            public Tweet(int id) {
                this.id = id;
                this.time = timestamp++;
            }
        }

        HashMap<Integer, Tweet> userTweets;
        HashMap<Integer, Set<Integer>> userFollowings;

        public Twitter() {
            userTweets = new HashMap<>();
            userFollowings = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.next = userTweets.getOrDefault(userId, null);
            userTweets.put(userId, t);
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<>(Comparator.comparingInt(t -> -t.time));
            Set<Integer> followings = userFollowings.getOrDefault(userId, new HashSet<>());
            followings.add(userId);
            for (Integer following : followings) {
                if(userTweets.containsKey(following)){
                    pq.add(userTweets.get(following));
                }
            }
            List<Integer> res = new ArrayList<>();
            while (!pq.isEmpty() && res.size() < 10){
                Tweet t = pq.poll();
                res.add(t.id);
                if (t.next!=null) pq.offer(t.next);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followings = userFollowings.getOrDefault(followerId, new HashSet<>());
            followings.add(followeeId);
            userFollowings.put(followerId, followings);
        }

        public void unfollow(int followerId, int followeeId) {
            if(!userFollowings.containsKey(followerId)) return;
            Set<Integer> followings = userFollowings.get(followerId);
            followings.remove(followeeId);
        }
    }
}
