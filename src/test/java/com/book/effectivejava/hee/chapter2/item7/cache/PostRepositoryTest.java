package com.book.effectivejava.hee.chapter2.item7.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        Integer p1 = 1;
        postRepository.getPostById(p1);

        assertFalse(postRepository.getCache().isEmpty());

        // TODO run gc
        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        assertTrue(postRepository.getCache().isEmpty());
    }
}