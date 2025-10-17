import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './style.css';
import config from './config.js';

const PlaylistManager = () => {
  const [songs, setSongs] = useState([]);
  const [song, setSong] = useState({
    id: '',
    title: '',
    artist: '',
    mood: '',
    album: '',
    year: '',
  });
  const [idToFetch, setIdToFetch] = useState('');
  const [fetchedSong, setFetchedSong] = useState(null);
  const [message, setMessage] = useState('');
  const [editMode, setEditMode] = useState(false);

  const baseUrl = `${config.url}/musicapi`;

  useEffect(() => {
    fetchAllSongs();
  }, []);

  const fetchAllSongs = async () => {
    try {
      const res = await axios.get(`${baseUrl}/all`);
      setSongs(res.data);
    } catch (error) {
      setMessage('Failed to fetch songs.');
    }
  };
 

  const handleChange = (e) => {
    setSong({ ...song, [e.target.name]: e.target.value });
  };

  const validateForm = () => {
    for (let key in song) {
      if (!song[key] || song[key].toString().trim() === '') {
        setMessage(`Please fill out the ${key} field.`);
        return false;
      }
    }
    return true;
  };

  const addSong = async () => {
    if (!validateForm()) return;
    try {
      await axios.post(`${baseUrl}/add`, song);
      setMessage('Song added successfully.');
      fetchAllSongs();
      resetForm();
    } catch (error) {
      setMessage('Error adding song.');
    }
  };

  const updateSong = async () => {
    if (!validateForm()) return;
    try {
      await axios.put(`${baseUrl}/update`, song);
      setMessage('Song updated successfully.');
      fetchAllSongs();
      resetForm();
    } catch (error) {
      setMessage('Error updating song.');
    }
  };

  const deleteSong = async (id) => {
    try {
      const res = await axios.delete(`${baseUrl}/delete/${id}`);
      setMessage(res.data);
      fetchAllSongs();
    } catch (error) {
      setMessage('Error deleting song.');
    }
  };

  const getSongById = async () => {
    try {
      const res = await axios.get(`${baseUrl}/get/${idToFetch}`);
      setFetchedSong(res.data);
      setMessage('');
    } catch (error) {
      setFetchedSong(null);
      setMessage('Song not found.');
    }
  };

  const handleEdit = (song) => {
    setSong(song);
    setEditMode(true);
    setMessage(`Editing song with ID ${song.id}`);
  };

  const resetForm = () => {
    setSong({
      id: '',
      title: '',
      artist: '',
      mood: '',
      album: '',
      year: '',
    });
      
    setEditMode(false);
  };

  return (
    <div className="song-container">

{message && (
  <div className={`message-banner ${message.toLowerCase().includes('error') ? 'error' : 'success'}`}>
    {message}
  </div>
)}


      <h2>Playlist Management - Happy Mood</h2>

      <div>
        
        <h3>{editMode ? 'Edit Song' : 'Add Song'}</h3>
        <div className="form-grid">
          <input type="number" name="id" placeholder="ID" value={song.id} onChange={handleChange} />
          <input type="text" name="title" placeholder="Title" value={song.title} onChange={handleChange} />
          <input type="text" name="artist" placeholder="Artist" value={song.artist} onChange={handleChange} />
                   <input type="text" name="mood" placeholder="Mood" value={song.mood} onChange={handleChange} />

          <input type="text" name="album" placeholder="Album" value={song.album} onChange={handleChange} />
          <input type="number" name="year" placeholder="Year" value={song.year} onChange={handleChange} />
        </div>
         
        

        <div className="btn-group">
          {!editMode ? (
            <button className="btn-blue" onClick={addSong}>Add Song</button>
          ) : (
            <>
              <button className="btn-green" onClick={updateSong}>Update Song</button>
              <button className="btn-gray" onClick={resetForm}>Cancel</button>
            </>
          )}
        </div>
      </div>

      <div>
        <h3>Get Song By ID</h3>
        <input
          type="number"
          value={idToFetch}
          onChange={(e) => setIdToFetch(e.target.value)}
          placeholder="Enter ID"
        />
        <button className="btn-blue" onClick={getSongById}>Fetch</button>

        {fetchedSong && (
          <div>
            <h4>Song Found:</h4>
            <pre>{JSON.stringify(fetchedSong, null, 2)}</pre>
          </div>
        )}
      </div>

      <div>
        <h3>All Songs</h3>
        {songs.length === 0 ? (
          <p>No songs found.</p>
        ) : (
          <div className="table-wrapper">
            <table>
              <thead>
                <tr>
                  {Object.keys(song).map((key) => (
                    <th key={key}>{key}</th>
                  ))}
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {songs.map((music) => (
                  <tr key={music.id}>
                    {Object.keys(music).map((key) => (
                      <td key={key}>{music[key]}</td>
                    ))}
                    <td>
                      <div className="action-buttons">
                        <button className="btn-green" onClick={() => handleEdit(music)}>Edit</button>
                        <button className="btn-red" onClick={() => deleteSong(music.id)}>Delete</button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>

    </div>
  );
};

export default PlaylistManager;
