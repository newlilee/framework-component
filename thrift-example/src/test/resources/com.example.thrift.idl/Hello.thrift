namespace java org.demo.thrift

service HelloService {
	string helloString(1:string param)
	i32 helloInt(1:i32 param)
	bool helloBoolean(1:bool param)
	void helloVoid()
	string helloNull()
}