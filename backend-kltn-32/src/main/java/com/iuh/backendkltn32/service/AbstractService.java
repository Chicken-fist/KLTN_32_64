package com.iuh.backendkltn32.service;

import java.util.Optional;

public interface AbstractService<T> {
	
	T layTheoMa(String ma) throws Exception;
	T luu(T obj) throws Exception ;
	String xoa(String ma) throws Exception ;
	T capNhat(T obj) throws Exception ;

}
