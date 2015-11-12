/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012. 
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.api;



/**
 * <p>
 * A protocol relationship between endpoints
 * </p>
 * <p>
 * The implementation of this interface is actual wrapper over Socket that
 * know's how to communicate with peer. The user of Association shouldn't care
 * if the underlying Socket is client or server side
 * </p>
 * <p>
 * 
 * </p>
 * 
 * @author amit bhayani
 * 
 */
public interface Association {


	public IpChannelType getIpChannelType();


	public AssociationType getAssociationType();

	public String getName();


	public boolean isStarted();


	public boolean isConnected();


	public boolean isUp();


	public AssociationListener getAssociationListener();


	public void setAssociationListener(AssociationListener associationListener);


	public String getHostAddress();


	public int getHostPort();


	public String getPeerAddress();


	public int getPeerPort();


	public String getServerName();
	

	public String[] getExtraHostAddresses();

	public void send(PayloadData payloadData) throws Exception;


	public void acceptAnonymousAssociation(AssociationListener associationListener) throws Exception;

	/**
	 * Use this method only for rejecting anonymous connections
	 * from the ServerListener.onNewRemoteConnection() invoking
	 */
	public void rejectAnonymousAssociation();

	public void stopAnonymousAssociation() throws Exception;

}
