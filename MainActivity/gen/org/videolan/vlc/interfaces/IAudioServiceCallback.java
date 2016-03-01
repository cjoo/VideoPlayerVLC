/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\android_other\\MainActivity\\src\\org\\videolan\\vlc\\interfaces\\IAudioServiceCallback.aidl
 */
package org.videolan.vlc.interfaces;
public interface IAudioServiceCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.videolan.vlc.interfaces.IAudioServiceCallback
{
private static final java.lang.String DESCRIPTOR = "org.videolan.vlc.interfaces.IAudioServiceCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an org.videolan.vlc.interfaces.IAudioServiceCallback interface,
 * generating a proxy if needed.
 */
public static org.videolan.vlc.interfaces.IAudioServiceCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.videolan.vlc.interfaces.IAudioServiceCallback))) {
return ((org.videolan.vlc.interfaces.IAudioServiceCallback)iin);
}
return new org.videolan.vlc.interfaces.IAudioServiceCallback.Stub.Proxy(obj);
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
case TRANSACTION_update:
{
data.enforceInterface(DESCRIPTOR);
this.update();
reply.writeNoException();
return true;
}
case TRANSACTION_updateProgress:
{
data.enforceInterface(DESCRIPTOR);
this.updateProgress();
reply.writeNoException();
return true;
}
case TRANSACTION_onMediaPlayedAdded:
{
data.enforceInterface(DESCRIPTOR);
org.videolan.libvlc.Media _arg0;
if ((0!=data.readInt())) {
_arg0 = org.videolan.libvlc.Media.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.onMediaPlayedAdded(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onMediaPlayedRemoved:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onMediaPlayedRemoved(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.videolan.vlc.interfaces.IAudioServiceCallback
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
@Override public void update() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_update, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void updateProgress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_updateProgress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMediaPlayedAdded(org.videolan.libvlc.Media media, int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((media!=null)) {
_data.writeInt(1);
media.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_onMediaPlayedAdded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMediaPlayedRemoved(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_onMediaPlayedRemoved, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_update = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_updateProgress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onMediaPlayedAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onMediaPlayedRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void update() throws android.os.RemoteException;
public void updateProgress() throws android.os.RemoteException;
public void onMediaPlayedAdded(org.videolan.libvlc.Media media, int index) throws android.os.RemoteException;
public void onMediaPlayedRemoved(int index) throws android.os.RemoteException;
}
