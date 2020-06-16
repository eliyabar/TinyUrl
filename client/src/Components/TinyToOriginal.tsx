import React, {FunctionComponent, useEffect, useState} from 'react';
import {Button, Input} from 'antd';
import { SyncOutlined } from '@ant-design/icons';
import axios from 'axios';

interface OwnProps {
    showError: (str: string)=>void,
}

type Props = OwnProps;

const TinyToOriginal: FunctionComponent<Props> = (props) => {
    const [loading, setLoading] = useState(false);
    const [fullUrl, setFullUrl] = useState('')
    const [tinyUrl, setTinyUrl] = useState('')

    const onClick = async (event: React.MouseEvent<HTMLElement>) => {
        if (tinyUrl.length) {
            setLoading(true)
            axios.get(`http://localhost:3005/url/${tinyUrl}`,)
                .then(response => {
                    setFullUrl(response.data)
                    console.log(response.data)
                }).catch(error => {props.showError(error.message)})
                .finally(()=>setLoading(false))
        } else {
            props.showError('Tiny Cannot be empty.')
        }
        event.preventDefault()
    }
    useEffect(()=>{
        //..
    }, [fullUrl,tinyUrl])

    return (
        <div style={{width: '80%'}}>
            <p>Get Original URL</p>
            <div style={{marginBottom: 16}}>
                <Input onChange={(e) => {setTinyUrl(e?.target?.value)}} value={tinyUrl} addonBefore={"http://localhost:3005/url/"}/>
            </div>
            <Button onClick={onClick} style={{marginBottom: 16}} type="primary" shape="round" icon={<SyncOutlined/>} size={'large'}
                    loading={loading}/>
            <div style={{marginBottom: 16}}>
                <Input value={fullUrl}/>
            </div>
            <Button type="primary" danger onClick={()=>{setTinyUrl(''); setFullUrl('')}}>
                Clear
            </Button>
            <p>You can also use the tinyUrl as a url to retrieve the original url as a response</p>
        </div>
    );
};

export default TinyToOriginal;
