package com.usedbook.service;

import com.usedbook.pojo.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAllMajor(int mFatherId);
}
