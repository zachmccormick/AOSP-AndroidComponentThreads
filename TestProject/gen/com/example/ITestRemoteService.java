/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/zachmccormick/Documents/workspace/TestProject/src/com/example/ITestRemoteService.aidl
 */
package com.example;
public interface ITestRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.ITestRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.example.ITestRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.ITestRemoteService interface,
 * generating a proxy if needed.
 */
public static com.example.ITestRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.ITestRemoteService))) {
return ((com.example.ITestRemoteService)iin);
}
return new com.example.ITestRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_go:
{
data.enforceInterface(DESCRIPTOR);
this.go();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.ITestRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void go() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_go, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_go = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void go() throws android.os.RemoteException;
}
