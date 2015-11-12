/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package org.mobicents.protocols.api;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * {@link Management} class manages the underlying {@link Association} and
 * {@link Server}.
 * </p>
 * <p>
 * Management should persist the state of {@link Server} and {@link Association}
 * </p>
 * <p>
 * Management when {@link #start() started} looks for file <tt>XXX_sctp.xml</tt> containing serialized state of underlying
 * {@link Association} and {@link Server}. Set the directory path by calling {@link #setPersistDir(String)} to direct Management to look at specified
 * directory for underlying serialized file.
 * </p>
 * <p>
 * If directory path is not set, Management searches for system property
 * <tt>sctp.persist.dir</tt> to get the path for directory
 * </p>
 * <p>
 * Even if <tt>sctp.persist.dir</tt> system property is not set,
 * Management will look at System set property <tt>user.dir</tt>
 * </p>
 * 
 * @author amit bhayani
 * 
 */
public interface Management {

	public String getName();
	

	public String getPersistDir();

	public void setPersistDir(String persistDir);


	public ServerListener getServerListener();


	public void setServerListener(ServerListener serverListener);

	public void addManagementEventListener(ManagementEventListener listener);

	public void removeManagementEventListener(ManagementEventListener listener);

	public void start() throws Exception;

	public void stop() throws Exception;

	public boolean isStarted();

	public void removeAllResourses() throws Exception;
	
	public Server addServer(String serverName, String hostAddress, int port, IpChannelType ipChannelType, boolean acceptAnonymousConnections,
			int maxConcurrentConnectionsCount, String[] extraHostAddresses) throws Exception;

	public Server addServer(String serverName, String hostAddress, int port, IpChannelType ipChannelType, String[] extraHostAddresses) throws Exception;


	public Server addServer(String serverName, String hostAddress, int port) throws Exception;
	

	public void removeServer(String serverName) throws Exception;


	public void startServer(String serverName) throws Exception;

	public void stopServer(String serverName) throws Exception;


	public List<Server> getServers();

	public Association addServerAssociation(String peerAddress, int peerPort, String serverName, String assocName) throws Exception;


	public Association addServerAssociation(String peerAddress, int peerPort, String serverName, String assocName, IpChannelType ipChannelType)
			throws Exception;


	public Association addAssociation(String hostAddress, int hostPort, String peerAddress, int peerPort, String assocName)
			throws Exception;


	public Association addAssociation(String hostAddress, int hostPort, String peerAddress, int peerPort, String assocName, IpChannelType ipChannelType,
			String[] extraHostAddresses) throws Exception;


	public void removeAssociation(String assocName) throws Exception;

	public Association getAssociation(String assocName) throws Exception;

	public Map<String, Association> getAssociations();


	public void startAssociation(String assocName) throws Exception;


	public void stopAssociation(String assocName) throws Exception;


	public int getConnectDelay();


	public void setConnectDelay(int connectDelay) throws Exception;


	public int getWorkerThreads();


	public void setWorkerThreads(int workerThreads) throws Exception;

	public boolean isSingleThread();

	public void setSingleThread(boolean singleThread) throws Exception;
}
